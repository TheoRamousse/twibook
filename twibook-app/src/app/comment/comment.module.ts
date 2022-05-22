import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IonicModule } from '@ionic/angular';
import { CommentComponent } from './comment.component';
import { MatDividerModule } from '@angular/material/divider';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from "@angular/material/button";


@NgModule({
    imports: [CommonModule, FormsModule, IonicModule, MatCardModule, MatButtonModule, MatDividerModule],
    declarations: [CommentComponent],
    exports: [CommentComponent]
})
export class CommentComponentModule {
}
