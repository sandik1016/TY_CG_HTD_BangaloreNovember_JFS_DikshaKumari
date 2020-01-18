import { Component, OnInit } from '@angular/core';
import { PostService } from '../post.service';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {

  message: any;
  posts: Post[];
  constructor( private postService: PostService
    
    ) { 
    this.getProducts();
  }

  ngOnInit() {
  }
  getProducts() {
    this.postService.getData().subscribe(response => {
      console.log(response);
      this.posts = response;

    }, err => {
      console.log(err);
    });
  }
  
  deleteProduct(post: Post) {
    this.postService.deleteData(post).subscribe(res => {
      console.log(res);
      if(res.message === 'deleted successfully') {
        this.posts.splice(this.posts.indexOf(post),1);
        this.message=res.message;
      }
    });
  }
}
