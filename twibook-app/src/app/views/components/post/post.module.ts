import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IonicModule } from '@ionic/angular';
import { PostComponent } from './post.component';
import { CommentComponentModule } from '../comment/comment.module';
import { MatDividerModule } from '@angular/material/divider';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from "@angular/material/button";


@NgModule({
    imports: [CommonModule, FormsModule, IonicModule, MatCardModule, MatButtonModule, MatDividerModule, CommentComponentModule],
    declarations: [PostComponent],
    exports: [PostComponent]
})
export class PostComponentModule {
}
