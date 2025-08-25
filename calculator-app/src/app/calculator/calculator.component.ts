import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-calculator',
  standalone: true,
  imports: [FormsModule, CommonModule],  // ✅ standalone requires declaring modules
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent {
  currentInput: string = '';
  previousValue: string = '';
  operator: string = '';

  numbers: string[] = ['7', '8', '9', '4', '5', '6', '1', '2', '3', '0', '.'];
  operators: string[] = ['+', '-', '*', '/'];

  appendNumber(num: string) {
    this.currentInput += num;
  }

  chooseOperator(op: string) {
    if (this.currentInput === '') return;
    this.operator = op;
    this.previousValue = this.currentInput;
    this.currentInput = '';
  }

  clear() {
    this.currentInput = '';
    this.previousValue = '';
    this.operator = '';
  }

  calculate() {
    if (this.currentInput === '' || this.previousValue === '') return;
    const prev = parseFloat(this.previousValue);
    const current = parseFloat(this.currentInput);

    let result: number = 0;
    switch (this.operator) {
      case '+': result = prev + current; break;
      case '-': result = prev - current; break;
      case '*': result = prev * current; break;
      case '/': result = current !== 0 ? prev / current : NaN; break;
    }

    this.currentInput = result.toString();
    this.previousValue = '';
    this.operator = '';
  }
}
