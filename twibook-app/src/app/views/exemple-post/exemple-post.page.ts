import { Component } from '@angular/core';
import { Post } from '../../model/Post'
import { PersistenceTemplateService } from '../../services/persistence-template.service';
import { StubService } from '../../services/stub.service';

@Component({
  selector: 'app-exemple-post',
  templateUrl: 'exemple-post.page.html',
  styleUrls: ['exemple-post.page.scss'],
  providers: [
    { provide: PersistenceTemplateService, useClass: StubService },
  ]
})
export class ExemplePostPage {
  post: Post
  constructor(pers: PersistenceTemplateService) {
    this.post = pers.getPostById("1");
  }

}
