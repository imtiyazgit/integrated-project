import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-servers',
  //selector: '[app-servers]',
  //selector: '.app-servers',
  //template: '<app-server></app-server><app-server></app-server>',
  templateUrl: './servers.component.html',
  styleUrls: ['./servers.component.css']
})
export class ServersComponent implements OnInit {
  serverId:number = 10;
  serverStatus:string = 'offline';
  allowNewServer = false;
  onCreateServerFlag = false;
  htmlInputName = 'TestValue';


  constructor() {
  this.allowNewServer = true;
    setTimeout(() => {
      this.allowNewServer = true;
    }, 2000);

  }

  ngOnInit(){}

  getServerStatus() {
    return this.serverStatus;
  }

  onCreateServer() {
    this.onCreateServerFlag = true;
  }

  onInputFromUser(event : any) {
    console.log(event);
    //htmlInputName
  }
}
