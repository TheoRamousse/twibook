import { Component, HostListener, Directive, Inject, ViewChild } from '@angular/core';
import { Post } from '../../model/Post'
import { PersistenceTemplateService } from '../../services/persistence-template.service';
import { StubService } from '../../services/stub.service';
import { Router } from '@angular/router';
import { AppControllerService } from '../../services/app-controller.service';
import { WINDOW } from "../../services/window.service";
import { DOCUMENT } from '@angular/common';
import { IonContent } from '@ionic/angular';
import { CameraService } from '../../services/camera.service';
import { DomSanitizer, SafeResourceUrl, SafeUrl } from '@angular/platform-browser';
import { defineCustomElements } from '@ionic/pwa-elements/loader'
import { from, Observable, observable, PartialObserver, Subscription } from 'rxjs';

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
  private urlImage: SafeUrl
  private text = ""
  private subscription: Subscription
  private base64ToSaveAsImageUrl: string

  @ViewChild(IonContent) content: IonContent;

  isLoading = false

  constructor(private _sanitizer: DomSanitizer, public cameraService: CameraService, private controlleur: AppControllerService, private router: Router, @Inject(WINDOW) private window: Window, @Inject(DOCUMENT) private document: Document) {
    defineCustomElements(window);
  }

  @HostListener('scroll', ['$event'])
  async scrolling(event: any) {
    const scrollElement = await this.content.getScrollElement();
    // calculate if max bottom was reached
    if (
      scrollElement.scrollTop ===
      scrollElement.scrollHeight - scrollElement.clientHeight
    ) {
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

  onPostSent() {
    var newPost = new Post("0", this.text, new Date(Date.now()), this.controlleur.user!.imageUrl, this.controlleur.user!.nickName, undefined, undefined, undefined, undefined, this.base64ToSaveAsImageUrl)
    this.controlleur.addNewPost(newPost)
    this.posts = [newPost].concat(this.posts)
    this.text = ""
    this.urlImage = ""
  }

  onOpenCamera() {
    var sanitizerTmp = this._sanitizer
    var imageTmp: SafeResourceUrl
    var self = this;

    this.cameraService.addNewToGalleryAndGet().then(function (base64) {
      self.base64ToSaveAsImageUrl = base64
      self.urlImage = sanitizerTmp.bypassSecurityTrustUrl(base64);
    })




  }

}