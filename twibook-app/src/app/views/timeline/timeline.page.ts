import { Component } from '@angular/core';
import { Post } from '../../model/Post'
import { PersistenceTemplateService } from '../../services/persistence-template.service';
import { StubService } from '../../services/stub.service';

@Component({
  selector: 'app-timeline',
  templateUrl: 'timeline.page.html',
  styleUrls: ['timeline.page.scss'],
  providers: [
    { provide: PersistenceTemplateService, useClass: StubService },
  ]
})
export class TimelinePage {
  private posts: Array<Post> = []
  private NbPostsToLoad = 2
  private pageNumber = 1
  private loadMoreVisibility = "visible"

  constructor(private pers: PersistenceTemplateService) {
  }

  private onLoadNextPosts() {
    this.posts.push(...this.pers.getPostsPagined(this.pageNumber, this.NbPostsToLoad))
    this.pageNumber += 1
  }

  ngOnInit() {
    this.onLoadNextPosts()
  }

}
