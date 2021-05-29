import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  about = 'This MES has been implemented with a lot of tears coffee, and bad gay jokes.';
  constructor() { }

  ngOnInit(): void {
  }

}
