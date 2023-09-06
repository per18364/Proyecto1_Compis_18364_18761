import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'removeEscape',
})
export class RemoveEscapePipe implements PipeTransform {
  transform(value: string): string {
    return value.replace(/\\n/g, '');
  }
}
