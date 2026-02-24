import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const API_KEY = '1d1a538338aaac91dbf1adc28d4663aa'; // Use v3
const BASE_URL =
  'http://api.themoviedb.org/3/discover/movie?api_key=' + API_KEY;

const GENRE_URL =
  'https://api.themoviedb.org/3/genre/movie/list?api_key=' + API_KEY;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['app.component.css'],
})
export class AppComponent {
  searchURL!: string;
  _movieArray!: Array<any>;
  _genreArray!: Array<any>;
  _http: HttpClient;
  today!: Date;
  dateRange!: string;
  genreID!: string;
  genreIDString!: string;


  constructor(private http: HttpClient) {
    this._http = http;
    this.today = new Date();
    this.dateRange = this.getDateRange(this.today);
    this.genreIDString = this.getGenreID(this.genreID);
    this.searchURL = BASE_URL + this.dateRange;

    console.log('constructor firing');
  }

  ngOnInit() {
    console.log('ngInit running');
    this.getMovies(this.searchURL);
    this.getGenres();
  }

  getGenreID(id: string) {
    // &with_genres=16
    let output = '&with_genres=' + id;
    //alert('genre string: ' + output);
    return output;
  }

  updateURL() {
    if (this.genreID) {
      let output = this.getGenreID(this.genreID)
      // alert("update fired" + output)
      return output;
    } else {
      return '';
    }
  }

  updateSearch(){
    let newSearchURL = this.searchURL;
    newSearchURL = newSearchURL + this.updateURL();
    this.getMovies(newSearchURL);
  }

  getDateRange(dt: Date) {
    let currentDate = dt;
    let thirtyDaysAgo = new Date();
    thirtyDaysAgo.setDate(this.today.getDate() - 30);
    let currentDateString = this.getFormattedDate(currentDate);
    let thirtyDaysAgoString = this.getFormattedDate(thirtyDaysAgo);
    let dateRangeString =
      '&primary_release_date.gte=' +
      thirtyDaysAgoString +
      '&primary_release_date.lte=' +
      currentDateString;
    // alert("date range: " + dateRangeString);

    return dateRangeString;
  }

  getFormattedDate(dt: Date) {
    let fMonth: string;
    let year = dt.getFullYear();
    let month = dt.getMonth() + 1;

    if (month < 10) {
      fMonth = '0' + month;
    } else {
      fMonth = '' + month;
    }

    let day = dt.getDate();
    let formattedDate = year + '-' + fMonth + '-' + day;
    // alert('formatted date: ' + formattedDate);
    return formattedDate.toString();
  }

  getMovies(checkUrl: string) {
    this._http
      .get<any>(checkUrl)

      // Get data and wait for result.
      .subscribe(
        (data) => {
          let page = data.page;
          let totalPages = data.total_pages;
          // alert('Page number: ' + page + ' Total Pages: ' + totalPages);
          this._movieArray = data.results;
        },
        (error) => {
          // Let user know about the error.
          alert(error);
          console.error(error);
        }
      );
  }

  getGenres() {
    this._http
      .get<any>(GENRE_URL)
      // Get data and wait for result.
      .subscribe(
        (data) => {
          this._genreArray = data.genres;
          // alert(JSON.stringify(this._genreArray));
        },

        (error) => {
          // Let user know about the error.
          alert(error);
          console.error(error);
        }
      );
  }
}
