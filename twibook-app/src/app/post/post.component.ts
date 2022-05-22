import { Component, OnInit, Input } from '@angular/core';
import { Post } from '../../model/Post'

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.scss'],
})
export class PostComponent implements OnInit {
  @Input() isCommentVisible: Boolean = true;
  @Input() currentPost: Post

  constructor() { }

  ngOnInit() { }

}
