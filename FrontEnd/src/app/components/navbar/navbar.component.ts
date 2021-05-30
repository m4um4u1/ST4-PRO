import { Component, OnInit } from '@angular/core';
import { StateService } from '../../services/state.service';
import {State} from '../../models/state.model';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  state: State;
  stateText: string;
  constructor(private stateService: StateService) { }

  ngOnInit(): void {
    setInterval(() => {
      this.stateService.getStateData().subscribe((response: State) => {
        this.state = response;
        switch (this.state?.state) {
          case 0: {
            this.stateText = 'Deactivated';
            break;
          }
          case 1: {
            this.stateText = 'Clearing';
            break;
          }
          case 2: {
            this.stateText = 'Stopped';
            break;
          }
          case 3: {
            this.stateText = 'Starting';
            break;
          }
          case 4: {
            this.stateText = 'Idle';
            break;
          }
          case 5: {
            this.stateText = 'Suspended';
            break;
          }
          case 6: {
            this.stateText = 'Execute';
            break;
          }
          case 7: {
            this.stateText = 'Stopping';
            break;
          }
          case 8: {
            this.stateText = 'Aborting';
            break;
          }
          case 9: {
            this.stateText = 'Aborted';
            break;
          }
          case 10: {
            this.stateText = 'Holding';
            break;
          }
          case 11: {
            this.stateText = 'Held';
            break;
          }
          case 15: {
            this.stateText = 'Resetting';
            break;
          }
          case 16: {
            this.stateText = 'Completing';
            break;
          }
          case 17: {
            this.stateText = 'Complete';
            break;
          }
          case 18: {
            this.stateText = 'Deactivating';
            break;
          }
          case 19: {
            this.stateText = 'Activating';
            break;
          }
          default: {
            this.stateText = 'No connection';
            break;
          }
        }
      });
    }, 5000);
}
}
