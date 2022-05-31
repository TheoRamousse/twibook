import { Component, OnInit, Input } from '@angular/core';
import { Post } from '../../../model/Post'
import { Comment } from '../../../model/Comment'
import { AppControllerService } from '../../../services/app-controller.service'

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.scss'],
})
export class PostComponent implements OnInit {
  private comments: Array<Comment> = []
  private NbCommentsToLoad = 1
  private pageNumber = 1
  private loadMoreVisibility = "visible"
  @Input() currentPost: Post
  private isCommentVisible: Boolean = true;

  constructor(private controlleur: AppControllerService) {
   }


  private onLoadNextComments(){
    var idsNewComments = this.paginator(this.currentPost.idComments, this.pageNumber, this.NbCommentsToLoad)

    idsNewComments.forEach(el => this.comments.push(this.controlleur.getCommentById(el)))
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

  ngOnInit() {
    this.onLoadNextComments()
  }

}
