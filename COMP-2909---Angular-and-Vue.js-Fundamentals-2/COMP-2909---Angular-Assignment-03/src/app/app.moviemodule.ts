import { Component, Input } from '@angular/core';

@Component({
  selector: 'movie-card',
  template: `
    <div>
      <img src="http://image.tmdb.org/t/p/w300/{{ poster_path }}" />
      <br />
      <span class="title">Title:</span> {{ mTitle }} <br />
      <span class="title">Release Date</span> {{ release_date }} <br />
      <span class="title">Synopsis:</span>
      {{ overview.length > 97 ? (overview | slice: 0:100) + '...' : overview }}
    </div>
  `,
})
export class MovieModule {
  @Input()
  poster_path!: any;
  mTitle!: any;
  release_date!: any;
  overview!: any;
}
