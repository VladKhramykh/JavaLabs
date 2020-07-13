import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { DemoSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective } from './';

@NgModule({
  imports: [DemoSharedCommonModule],
  declarations: [JhiLoginModalComponent, HasAnyAuthorityDirective],
  entryComponents: [JhiLoginModalComponent],
  exports: [DemoSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class DemoSharedModule {
  static forRoot() {
    return {
      ngModule: DemoSharedModule
    };
  }
}
