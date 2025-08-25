import { Component } from '@angular/core';
import { CalculatorComponent } from './calculator/calculator.component';  // ✅ correct path

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CalculatorComponent],  // ✅ standalone component import
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']  // ✅ must be plural
})
export class AppComponent {
  title = 'calculator-app';
}
