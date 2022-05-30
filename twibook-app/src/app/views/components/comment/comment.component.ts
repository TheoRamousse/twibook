import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.scss'],
})
export class CommentComponent implements OnInit {
  @Input() text: String;
  @Input() userNickName: String;
  @Input() userImageUrl: Boolean = true;
  @Input() publicationDate: Boolean = true;

  constructor() { }

  ngOnInit() { }

}
