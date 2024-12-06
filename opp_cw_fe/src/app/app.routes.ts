import { Routes } from '@angular/router';
import { MasterComponent } from './components/master/master.component';
import { VendorComponent } from './components/vendor/vendor.component';
import { CustomerComponent } from './components/customer/customer.component';

export const routes: Routes = [
    {
        path:'',
        redirectTo: 'master',
        pathMatch: 'full'

    },
    {
        path: 'master',
        component:MasterComponent
    },
    {
        path: 'vendor',
        component:VendorComponent
    },
    {
        path: 'customer',
        component:CustomerComponent
    }
];
