import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-mt-bar',
  templateUrl: './mt-bar.component.html',
  styleUrls: ['./mt-bar.component.css']
})
export class MtBarComponent implements OnInit {

  mtProcent = 10;

  constructor() { }

  ngOnInit(): void {
  }

}
