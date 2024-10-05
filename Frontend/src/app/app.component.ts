import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SearchBusComponent } from "../app/components/search-bus/search-bus.component";
import { HomePageComponent } from "./components/home-page/home-page.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, SearchBusComponent,HomePageComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Frontend';
}
