import { BookService } from './../book.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
books:any;
  constructor(private service: BookService){}
  ngOnInit(){
    this.books=this.service.getBooks().subscribe(data=>this.books=data);
  }
}
