import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';
import { LoginRegisterContainerComponentModule } from '../login-register-container/login-register-container.module';

import { ConnectionPage } from './connection.page';

describe('ConnectionPage', () => {
  let component: ConnectionPage;
  let fixture: ComponentFixture<ConnectionPage>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ConnectionPage],
      imports: [IonicModule.forRoot(), LoginRegisterContainerComponentModule]
    }).compileComponents();

    fixture = TestBed.createComponent(ConnectionPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
