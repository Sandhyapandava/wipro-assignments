// src/app/feedback/feedback.component.ts
import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';

import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule }      from '@angular/material/input';
import { MatButtonModule }     from '@angular/material/button';
import { MatCardModule }       from '@angular/material/card';
import { MatIconModule }       from '@angular/material/icon';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';

@Component({
  selector: 'app-feedback',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatCardModule,
    MatIconModule,
    MatSnackBarModule
  ],
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.scss']
})
export class FeedbackComponent {

  maxSubject = 40;
  maxComments = 350;
  submitted = false;

  feedbackForm: FormGroup;

  constructor(private readonly fb: FormBuilder, private readonly snack: MatSnackBar) {
    this.feedbackForm = this.fb.group({
      name:     ['', [Validators.required, Validators.minLength(2)]],
      email:    ['', [Validators.required, Validators.email]],
      subject:  ['', [Validators.required, Validators.maxLength(this.maxSubject)]],
      comments: ['', [Validators.required, Validators.maxLength(this.maxComments)]],
    });
  }

  get f() { return this.feedbackForm.controls; }

  onSubmit(): void {
    if (this.feedbackForm.invalid) {
      this.feedbackForm.markAllAsTouched(); // highlight all invalid fields
      return;
    }

    // Here you'd typically POST to your API.
    // For this demo we just flip the view and show a snackbar.
    this.submitted = true;
    this.snack.open('Thank you! We will get back to you shortly.', 'Close', { duration: 3000 });
  }

  reset(): void {
    this.submitted = false;
    this.feedbackForm.reset();
  }
}
