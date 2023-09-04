import { Component } from '@angular/core';
import { AnalysisService } from '../services/analysis.service';

@Component({
  selector: 'app-ide',
  templateUrl: './ide.component.html',
  styleUrls: ['./ide.component.css'],
})
export class IdeComponent {
  code: string = '';
  result: any;

  constructor(private analysisService: AnalysisService) {}

  analyze() {
    this.analysisService.analyzeCode(this.code).subscribe(
      (data) => {
        console.log(data);
        this.result = data;
      },
      (error) => {
        console.log('Error', error);
        this.result = error.error.errors;
      }
    );
  }
}
