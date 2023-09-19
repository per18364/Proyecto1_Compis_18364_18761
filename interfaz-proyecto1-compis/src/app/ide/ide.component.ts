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
  pdfUrl: string = '';

  constructor(private analysisService: AnalysisService) {}

  handleKeyEvent(event: KeyboardEvent) {
    if (event.key === 'Tab') {
      event.preventDefault();
      const start = (event.target as HTMLTextAreaElement).selectionStart;
      const end = (event.target as HTMLTextAreaElement).selectionEnd;
      const target = (event.target as HTMLTextAreaElement).value;

      (event.target as HTMLTextAreaElement).value =
        target.substring(0, start) + '    ' + target.substring(end);

      (event.target as HTMLTextAreaElement).selectionStart = (
        event.target as HTMLTextAreaElement
      ).selectionEnd = start + 4;
    }
  }

  updateLineNumbers() {
    const textarea = document.querySelector('textarea') as HTMLTextAreaElement;
    const lineNumbersDiv = document.querySelector(
      '.line-numbers'
    ) as HTMLElement;
    const lines = textarea.value.split('\n').length;

    lineNumbersDiv.innerHTML = '';
    for (let i = 1; i <= lines; i++) {
      const lineNumber = document.createElement('div');
      lineNumber.innerText = i.toString();
      lineNumbersDiv.appendChild(lineNumber);
      lineNumber.style.fontFamily = 'monospace';
      lineNumber.style.fontSize = '16px';
    }
  }

  syncScroll() {
    const textarea = document.querySelector('textarea') as HTMLTextAreaElement;
    const lineNumbersDiv = document.querySelector(
      '.line-numbers'
    ) as HTMLElement;
    lineNumbersDiv.scrollTop = textarea.scrollTop;
  }

  analyze() {
    this.analysisService.analyzeCode(this.code).subscribe(
      (data) => {
        // console.log(data);
        this.result = data;
        console.log('result', this.result);
      },
      (error) => {
        // console.log('Error', error);
        this.result = error.error;
        console.log('result', this.result);
      }
    );
    // const time = new Date().getTime();
    // this.pdfUrl = `../../assets/arbol_sintactico.pdf?ts=${time}`;
  }
}
