export class MedidasAntropometricas {
    private peso: number;
    private altura: number;
    private circunferenciaQuadril: number;
  
    constructor(peso: number, altura: number, circunferenciaQuadril: number) {
      this.peso = peso;
      this.altura = altura;
      this.circunferenciaQuadril = circunferenciaQuadril;
    }
  
    public getPeso(): number {
      return this.peso;
    }
  
    public setPeso(peso: number): void {
      this.peso = peso;
    }
  
    public getAltura(): number {
      return this.altura;
    }
  
    public setAltura(altura: number): void {
      this.altura = altura;
    }
  
    public getCircunferenciaQuadril(): number {
      return this.circunferenciaQuadril;
    }
  
    public setCircunferenciaQuadril(circunferenciaQuadril: number): void {
      this.circunferenciaQuadril = circunferenciaQuadril;
    }
  }
  