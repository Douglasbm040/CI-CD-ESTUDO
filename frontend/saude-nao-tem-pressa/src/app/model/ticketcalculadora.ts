import { MedidasAntropometricas } from './medidasantropometricas';

export class TicketCalculadora {
  public formaCalulo: number;
  public genero: number;
  public medida: MedidasAntropometricas;
  constructor(
    formaCalulo: number,
    genero: number,
    medida: MedidasAntropometricas
  ) {
    this.formaCalulo = formaCalulo;
    this.genero = genero;
    this.medida = medida;
  }
}
