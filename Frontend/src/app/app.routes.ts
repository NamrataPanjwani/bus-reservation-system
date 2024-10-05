import { Routes } from '@angular/router';
import { SearchBusComponent } from './components/search-bus/search-bus.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { SeatsComponent } from './components/seats/seats.component';

export const routes: Routes = [
    {
        path:"",
        component:HomePageComponent
    },
    {
        path:'search',
        component:SearchBusComponent
        
    },
    {
        path:'seats',
        component:SeatsComponent
    }
];
