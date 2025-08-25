import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'; // ✅ Add this
import { Movie } from './movie.model';

import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-movies',
  standalone: true,
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.scss'],
  imports: [
    CommonModule,
    FormsModule,              // ✅ Fix for ngModel
    MatFormFieldModule,
    MatSelectModule,
    MatCardModule,
    MatIconModule
  ]
})
export class MoviesComponent {
  genres: string[] = ['All', 'Action', 'Comedy', 'Drama', 'Sci-Fi'];

  movies: Movie[] = [
    {
      title: 'Inception',
      poster: 'image.png',
      genre: 'Sci-Fi',
      rating: 5,
      description: 'A thief enters dreams to steal secrets.'
    },
    {
      title: 'The Dark Knight',
      poster: 'dark.webp',
      genre: 'Action',
      rating: 5,
      description: 'Batman faces the Joker in Gotham.'
    },
    {
      title: 'Interstellar',
      poster: 'OIP.webp',
      genre: 'Sci-Fi',
      rating: 4,
      description: 'A journey beyond the stars to save humanity.'
    },
    {
      title: 'The Hangover',
      poster: 'hang.webp',
      genre: 'Comedy',
      rating: 3,
      description: 'Three friends wake up from a wild night in Vegas.'
    }
  ];

  selectedGenre: string = 'All';

  get filteredMovies(): Movie[] {
    if (this.selectedGenre === 'All') return this.movies;
    return this.movies.filter(m => m.genre === this.selectedGenre);
  }

  get averageRating(): number {
    const total = this.movies.reduce((sum, m) => sum + m.rating, 0);
    return +(total / this.movies.length).toFixed(1);
  }

  isTopRated(movie: Movie): boolean {
    const maxRating = Math.max(...this.movies.map(m => m.rating));
    return movie.rating === maxRating;
  }
}
