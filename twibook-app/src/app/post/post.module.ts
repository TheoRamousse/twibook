import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from "@angular/material/button";
import { IonicModule } from '@ionic/angular';
import { MatCardModule } from '@angular/material/card';
import { PostComponent } from './post.component';

@NgModule({
    imports: [CommonModule, FormsModule, IonicModule, MatCardModule, MatButtonModule],
    declarations: [PostComponent],
    exports: [PostComponent]
})
export class PostComponentModule { }