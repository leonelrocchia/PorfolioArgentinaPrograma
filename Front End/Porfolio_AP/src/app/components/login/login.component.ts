import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form: FormGroup;
  loading = false;
  
  constructor(private fb: FormBuilder, private _snackBar: MatSnackBar, private router: Router) { 
    this.form = this.fb.group({
      usuario: ['', Validators.required],
      password: ['', Validators.required]
    })
  }

  ngOnInit(): void {
  }

  ingresar(){
    const usuario = this.form.value.usuario;
    const password = this.form.value.password;

    if (usuario == 'admin' && password == '1234'){
      //logueado al inicio
      this.fakeLoading();
    } else{
      // mostramos un error;
      this.errorLogueo();
      this.form.reset();
    }
  }
  errorLogueo() {
    this._snackBar.open('El usuario y/o la contraseña ingresado/a no es válido.', '', {
      duration: 4000,
      horizontalPosition: 'center',
      verticalPosition: 'bottom'
    })
  }

  //como redireccionar a una ruta
  fakeLoading(){
    this.loading = true;
    setTimeout(() => {
        this.router.navigate([''])
    }, 1500);
  }
}
