import { Component, OnInit } from '@angular/core';
import { BreakpointObserver, Breakpoints} from '@angular/cdk/layout';
import { User } from 'src/app/model/user.model';
import { UserService } from 'src/app/service/user.service';


@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})
export class AcercaDeComponent implements OnInit {
  user: User = new User("", "", "", "", "");

  public colSize=4;
  public isMobile: boolean = false;

  

  constructor(breakpointObserver: BreakpointObserver,
              public userService: UserService) {
    breakpointObserver.observe([
      Breakpoints.Handset
    ]).subscribe(result => {
      this.isMobile = result.matches;
      if(this.isMobile){
        this.colSize=1;
      }else{
        this.colSize=4;
      }
    });
  }
  ngOnInit(): void {
    this.userService.getUser().subscribe(data => {this.user = data})
  }

}
