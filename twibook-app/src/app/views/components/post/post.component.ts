import { Component, OnInit, Input } from '@angular/core';
import { Post } from '../../../model/Post'
import { Comment } from '../../../model/Comment'
import { AppControllerService } from '../../../services/app-controller.service'
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.scss'],
})
export class PostComponent implements OnInit {
  private comments: Array<Comment> = []
  private NbCommentsToLoad = 2
  private pageNumber = 1
  private loadMoreVisibility = "visible"
  @Input() currentPost: Post
  private isCommentVisible: Boolean = true;
  private textComment: string = "";
  private imageUrl: SafeUrl = this._sanitizer.bypassSecurityTrustUrl("");

  constructor(private _sanitizer: DomSanitizer, private controlleur: AppControllerService) {
  }


  private async onLoadNextComments() {
    var idsNewComments = this.paginator(this.currentPost.idComments, this.pageNumber, this.NbCommentsToLoad)

    idsNewComments.forEach(async el => {
      this.controlleur.getCommentById(el).subscribe(function (comment) {
        this.comments.push(comment)
      })
    })
    this.pageNumber += 1
    this.loadMoreVisibility = this.paginator(this.currentPost.idComments, this.pageNumber, this.NbCommentsToLoad).length == 0 ? "hidden" : "visible"
  }

  private paginator(items: Array<string>, current_page: number, per_page_items: number): Array<string> {
    let page = current_page || 1,
      per_page = per_page_items || 1,
      offset = (page - 1) * per_page,

      paginatedItems = items.slice(offset).slice(0, per_page_items)

    return paginatedItems
  }

  private onCommentPosted() {
    var newComment = new Comment("0", this.textComment, new Date(Date.now()), this.controlleur.user.nickName, this.controlleur.user.imageUrl)
    this.controlleur.addNewComment(this.currentPost, newComment)
    this.comments.push(newComment)
    this.textComment = ""
  }

  ngOnInit() {
    this.imageUrl = this._sanitizer.bypassSecurityTrustUrl(this.currentPost.imageUrl);
    this.onLoadNextComments()
  }

}
