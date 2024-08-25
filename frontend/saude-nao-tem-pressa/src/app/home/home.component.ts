import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { FormasCalculo } from '../Uteis/formasCalculo';
import { CommonModule } from '@angular/common';
import { Observable } from 'rxjs';
import {
  HttpClient,
  HttpHeaders,
  HttpClientModule,
} from '@angular/common/http';
import { ConexoesUteis } from '../Uteis/conexoesUteis';
import { TicketCalculadora } from '../model/ticketcalculadora';
import { MedidasAntropometricas } from '../model/medidasantropometricas';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [FormsModule, CommonModule, HttpClientModule],
  templateUrl: './home.component.html',
  styleUrls: ['home.component.css'],
})
export class HomeComponent {
  selectedCalculation: String = FormasCalculo.IMC.toString(); // 0 => IMC
  altura: number = 0;
  peso: number = 0;
  idade: number = 0;
  circunferenciaQuadril: number = 0;
  genero: string = '';

  constructor(private http: HttpClient) {}

  postData(data: any): Observable<any> {
    const Heaears = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post(ConexoesUteis.URL_API, data, {
      headers: Heaears,
      responseType: 'json',
    });
  }

  validateForm(): boolean {
    if (
      this.altura < 0 ||
      this.peso < 0 ||
      this.idade < 0 ||
      this.circunferenciaQuadril < 0
    ) {
      alert('As medidas não podem ser negativas.');
      return false;
    }
    return true;
  }

  submitForm() {
    if (!this.validateForm()) {
      return;
    }

    const formData = new TicketCalculadora(
      Number.parseInt(this.selectedCalculation.toString()),
      Number.parseInt(this.genero.toString()),
      new MedidasAntropometricas(
        this.peso,
        this.altura,
        this.circunferenciaQuadril
      )
    );
    console.log(Number.parseInt(this.selectedCalculation.toString()));
    this.postData(formData).subscribe(
      (response) => {
        alert(response.message || 'Resposta do servidor não está disponível');
        console.log('Resposta do servidor:', response.message);
      },
      (error) => {
        console.error('Erro ao enviar dados:', error);
      }
    );
  }
}
