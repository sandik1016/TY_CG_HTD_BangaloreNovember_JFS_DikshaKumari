import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class PostService {

  posts: Post[];
  message: any;
  constructor(private http: HttpClient) { }

  getData(): Observable<any> {
    return this.http.get<any>(`https://jsonplaceholder.typicode.com/posts`);
  }

  deleteData(post: Post): Observable<any> {
    return this.http.delete<any>(
      `https://jsonplaceholder.typicode.com/posts/${post.id}`
    );
  }

  updateData(post: Post): Observable<any> {
    return this.http.put<any>(
      `https://jsonplaceholder.typicode.com/posts/update/${post.id}`, post
    );
  }
}
