import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { CustomersComponent } from './customers/customers.component';
import { AccountsComponent } from './accounts/accounts.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { NewCustomerComponent } from './new-customer/new-customer.component';
import { CustomerAccountsComponent } from './customer-accounts/customer-accounts.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { NewAccountComponent } from './new-account/new-account.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { MyaccountsComponent } from './myaccounts/myaccounts.component';
import { OperationsComponent } from './operations/operations.component';
import { TransferComponent } from './transfer/transfer.component';
import {RouterModule} from "@angular/router";

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    CustomersComponent,
    AccountsComponent,
    NewCustomerComponent,
    CustomerAccountsComponent,
    NotFoundComponent,
    NewAccountComponent,
    HomeComponent,
    LoginComponent,
    ForbiddenComponent,
    MyaccountsComponent,
    OperationsComponent,
    TransferComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
