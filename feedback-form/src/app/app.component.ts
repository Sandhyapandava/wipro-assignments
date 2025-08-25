// src/app/app.component.ts
import { Component } from '@angular/core';
import { FeedbackComponent } from './feedback/feedback.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FeedbackComponent],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {}
