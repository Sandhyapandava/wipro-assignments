import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

// Angular Material
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatOptionModule } from '@angular/material/core';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-playlist',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatFormFieldModule,
    MatSelectModule,
    MatOptionModule,
    MatCardModule,
    MatIconModule,
    MatButtonModule
  ],
  templateUrl: './playlist.component.html',
  styleUrls: ['./playlist.component.css']
})
export class PlaylistComponent {
 songs = [
  { 
    name: 'Baby', 
    artist: 'Justin Bieber', 
    album: 'My World', 
    duration: '2:20', 
    rating: 4,
    image: 'images.jpeg'   // 👈 Add poster path
  },
  { 
    name: 'Cheap Thrills', 
    artist: 'Sia', 
    album: 'This Is Acting', 
    duration: '4:20', 
    rating: 5,
    image: 'im.jpeg'
  },
  { 
    name: 'Your Wish', 
    artist: 'Talisco', 
    album: 'Run', 
    duration: '2:55', 
    rating: 3,
    image: 'ima.jpeg'
  },
];


  selectedArtist: string = '';
  selectedAlbum: string = '';

  get uniqueArtists(): string[] {
    return [...new Set(this.songs.map(s => s.artist))];
  }

  get uniqueAlbums(): string[] {
    return [...new Set(this.songs.map(s => s.album))];
  }

  get filteredSongs() {
    return this.songs.filter(song =>
      (this.selectedArtist ? song.artist === this.selectedArtist : true) &&
      (this.selectedAlbum ? song.album === this.selectedAlbum : true)
    );
  }

  get averageRating(): number {
    return this.songs.reduce((sum, song) => sum + song.rating, 0) / this.songs.length;
  }
}
