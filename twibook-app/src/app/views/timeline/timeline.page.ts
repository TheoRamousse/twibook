import { Component, HostListener, Directive, Inject } from '@angular/core';
import { Post } from '../../model/Post'
import { PersistenceTemplateService } from '../../services/persistence-template.service';
import { StubService } from '../../services/stub.service';
import { Router } from '@angular/router';
import { AppControllerService } from '../../services/app-controller.service';
import { WINDOW } from "../../services/window.service";
import { DOCUMENT } from '@angular/common';

@Component({
  selector: 'app-timeline',
  templateUrl: 'timeline.page.html',
  styleUrls: ['timeline.page.scss'],
  providers: [
    { provide: PersistenceTemplateService, useClass: StubService },
  ]
})
@Directive({ selector: '[trackScroll]' })
export class TimelinePage {
  private posts: Array<Post> = []
  private NbPostsToLoad = 2
  private pageNumber = 1

  isLoading = false

  constructor(private controlleur: AppControllerService, private router: Router, @Inject(WINDOW) private window: Window, @Inject(DOCUMENT) private document: Document) {
  }

  @HostListener('window:scroll', [])
  onWindowScroll() {
    console.log('bottom of the page')
    if (window.innerHeight + window.scrollY >= document.body.offsetHeight && !this.isLoading) {
      console.log("bottom of the page");
      this.pageNumber += 1;
      this.isLoading = true;
      this.onLoadNextPosts();
      this.isLoading = false;
    }
  }


  private onLoadNextPosts() {
    this.posts.push(...this.controlleur.getPostsPagined(this.pageNumber, this.NbPostsToLoad))
    this.pageNumber += 1
  }

  ngOnInit() {
    this.onLoadNextPosts()
  }

}
