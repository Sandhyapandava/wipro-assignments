import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PlaylistComponent } from './playlist/playlist.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, PlaylistComponent],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent { }
