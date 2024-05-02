export class Response {
  id: number;
  response: string;
  isTrue: boolean;

  constructor(id: number, response: string, isTrue: boolean) {
    this.id = id;
    this.response = response;
    this.isTrue = isTrue;
  }
}
