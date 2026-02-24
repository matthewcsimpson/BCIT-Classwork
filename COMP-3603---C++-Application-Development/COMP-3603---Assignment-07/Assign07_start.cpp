// Assignment 7: Assign07.cpp
// December 1st, 2022
// Author: Bob Langelaan

// Modified by: Matthew Simpson / A00820997
// Date: 23 July 2024
// Note: Please see note on part 9. 

// Note: This site will be usefull for this assignment:
// http://www.cplusplus.com/reference/
// Note that algorithms are under the "Other" category

#include <iostream>
#include <ctime>
#include <random> // needed to generate random #'s the C++ 11 manner
#include <vector>   // parts 1,2,4,5 and 9
#include <unordered_set> // part 3
#include <list>     // parts 6, 7 & 12
#include <deque>    // part 8 
#include <set>      // parts 11 & 13
#include <algorithm>
#include <execution> // required for the parallel sort

using namespace std;

const size_t four_billion = 4000000000;
// const size_t two_hundred_million = 200000000;
const size_t one_hundred_million = 100000000;
const size_t eighty_million = 80000000;
const size_t forty_million = 40000000;
const size_t ten_million = 10000000;
const size_t four_million = 4000000;
const size_t four_hundred_thousand = 400000;
const size_t one_hundred_thousand = 100000;
const size_t forty_thousand = 40000;


int main()
{

   time_t start_time;    /* used to store starting time */
   time_t end_time;      /* used to store end time */
   time_t total_time;    /* used to compute total time to compute solution */

   int part = 1; // used to display current part 

   default_random_engine engine( static_cast<unsigned int>( time(0) ) );
   uniform_int_distribution<size_t> randomInt( 1, four_billion); // 1 to 4 billion

   // Part 1 - Goal: To populate a vector of 100 million elements with random values between 
   //          1 and 4 billion and sort them using the conventional (non parallel) sort() algorithm.

   // NOTE: The vector is created/initialized with with 100 million elements (size() == 100 million)

   start_time = time(NULL); // record start time

   {

	   vector<size_t> v1(one_hundred_million);

       for (auto& value : v1) {
           value = randomInt(engine);// random number 1 to 4 billion
       }

	   sort(v1.begin(), v1.end());

   }
   
   end_time = time(NULL); // record end time
   total_time = end_time - start_time; // calculate time to compute
   cout << "It took " << static_cast<long>(total_time) << " seconds to compute Part " <<  part++ << "\n" << endl;

   // Part 2 - Goal: To populate a vector of 40 million elements with random values between 
   //          1 and 4 billion and sort them using a stable_sort() algorithm

   // If you are interested in knowing more about what makes a sort a stable sort and when it is required over
   // a regular sort, study the following web page:
   // https://www.baeldung.com/cs/stable-sorting-algorithms
   // The radix sort example referred to in the article is where I first became aware of the need for a stable sort.

   // NOTE: The vector is created/initialized with with 40 million elements (size() == 40 million)

   start_time = time(NULL); // record start time

   {

      vector<size_t> v2(forty_million);
      for (auto& value : v2) {
         value = randomInt(engine);
      }
      stable_sort(v2.begin(), v2.end());

   }
   
   end_time = time(NULL); // record end time
   total_time = end_time - start_time; // calculate time to compute
   cout << "It took " << static_cast<long>(total_time) << " seconds to compute Part " <<  part++ << "\n" << endl;

  // Part 3 - Goal: To populate an unsorted multiset of 40 million elements with random values between 
   //          1 and 4 billion.  

   // NOTE: The unsorted multiset is created/initialized with 0 elements (size() == 0)

   start_time = time(NULL); // record start time

   {
      unordered_multiset<size_t> ums;
      for (size_t i = 0; i < forty_million; ++i) {
         ums.insert(randomInt(engine));
      }
   }

   end_time = time(NULL); // record end time
   total_time = end_time - start_time; // calculate time to compute
   cout << "It took " << static_cast<long>(total_time) << " seconds to compute Part " << part++ << "\n" << endl;

  // Part 4 - Goal: To populate a vector of 40 million elements with random values between 
  //          1 and 4 billion while using some of the heap algorithms demonstrated in Fig. 16.12

  // Add elements to vector using push_back and push_heap.  When all elements have been added to the vector
  //          finish with sort_heap.

  // NOTE: The vector is created/initialized empty (size == 0)

   start_time = time(NULL); // record start time

   {
      vector<size_t> v4;
      v4.reserve(forty_million);
      for (size_t i = 0; i < forty_million; ++i) {
         v4.push_back(randomInt(engine));
         push_heap(v4.begin(), v4.end());
      }
      sort_heap(v4.begin(), v4.end());
   }
   
   end_time = time(NULL); // record end time
   total_time = end_time - start_time; // calculate time to compute
   cout << "It took " << static_cast<long>(total_time) << " seconds to compute Part " <<  part++ << "\n" << endl;

  // Part 5 - Goal: To populate a vector of 40 million elements with random values between 
  //          1 and 4 billion and use some of the heap algorithms demonstrated in Fig. 16.12

  // This time add elements to vector using push_back.  When all elements have been added to the vector
  //          finish with make_heap and then sort_heap.

  // NOTE: The vector is created/initialized empty (size == 0)

   start_time = time(NULL); // record start time

   {
      vector<size_t> v5;
      v5.reserve(forty_million);
      for (size_t i = 0; i < forty_million; ++i) {
         v5.push_back(randomInt(engine));
      }
      make_heap(v5.begin(), v5.end());
      sort_heap(v5.begin(), v5.end());
   }
   
   end_time = time(NULL); // record end time
   total_time = end_time - start_time; // calculate time to compute
   cout << "It took " << static_cast<long>(total_time) << " seconds to compute Part " <<  part++ << "\n" << endl;

  // Part 6 - Goal: To populate a list of 100 thousand elements with random values between 
  //          1 and 4 billion. No sort will be necessary since new values will be merged into the main
  //          list one element at a time.

  // Create a second list to which you will add one item and then use the list member function merge and _NOT_ the merge()
  //          algorithm to merge into the main list.  Repeat until all of the elements have been added to the main list.

  // NOTE: The 2 lists are created/initialized empty (size == 0)

   start_time = time(NULL); // record start time

   {
      list<size_t> l_main;
      list<size_t> l_temp;
      for (size_t i = 0; i < one_hundred_thousand; ++i) {
         l_temp.push_back(randomInt(engine));
         l_main.merge(l_temp);
      }
   }
   
   end_time = time(NULL); // record end time
   total_time = end_time - start_time; // calculate time to compute
   cout << "It took " << static_cast<long>(total_time) << " seconds to compute Part " <<  part++ << "\n" << endl;

  // Part 7 - Goal: To populate a list of 800 thousand elements with random values between 1 and 4 billion. No 
  //          sort will be necessary because new elements will be merged into the main list 400 elements at a time.

  // Create a second list to which you will add 400 new items, sort() and then use merge() to merge into the main list.
  //          Repeat 2000 times (400 * 2000 == 800 thousand).  Again, as with Part 6, you will be using the list member 
  //          function merge and not the merge() algorithm. Hint: Use nested for loops.

  // NOTE: The 2 lists are created/initialized empty (size == 0)

   start_time = time(NULL); // record start time

   {
      list<size_t> l_main;
      list<size_t> l_temp;
      for (size_t i = 0; i < 2000; ++i) {
         for (size_t j = 0; j < 400; ++j) {
            l_temp.push_back(randomInt(engine));
         }
         l_temp.sort();
         l_main.merge(l_temp);
      }
   }
   
   end_time = time(NULL); // record end time
   total_time = end_time - start_time; // calculate time to compute
   cout << "It took " << static_cast<long>(total_time) << " seconds to compute Part " <<  part++ << "\n" << endl;

   // Part 8 - Goal: To populate a deque of 40 million elements with random values between 
   //          1 and 4 billion and then sort using the sort() algorithm

   // NOTE: The deque is created/initialized with 40 million elements (size() == 40 million)

   start_time = time(NULL); // record start time

   {
      deque<size_t> d(forty_million);
      for (auto& value : d) {
         value = randomInt(engine);
      }
      sort(d.begin(), d.end());
   }
   
   end_time = time(NULL); // record end time
   total_time = end_time - start_time; // calculate time to compute
   cout << "It took " << static_cast<long>(total_time) << " seconds to compute Part " <<  part++ << "\n" << endl;

  // Part 9 - Goal: To populate a vector of 100 million elements with random values between 
   //          1 and 4 billion and sort them using the C++ 17 sort() algorithm that allows a parallel algorithm that uses multi-threading.
   //          If using Microsft Visual Studio IDE with C++ 17 features enabled, the sort statement is:
   //          sort(execution::par, v1.begin(), v1.end());

   // NOTE: The vector is created/initialized with with 100 million elements (size() == 100 million)

   start_time = time(NULL); // record start time

// -------------------------------------------------------------------
// Note, when I run this I get an "undeclared identifier" exception np matter what I do.  Maybe something do to with being on a mac. This is hwo I believe it should look, though. 

// {
//    vector<size_t> v9(one_hundred_million);
//    
//    for (auto& value : v9) {
//       value = randomInt(engine);
//    }
//    
//    sort(execution::par, v9.begin(), v9.end()); 
// }
   
   end_time = time(NULL); // record end time
   total_time = end_time - start_time; // calculate time to compute
   cout << "It took " << static_cast<long>(total_time) << " seconds to compute Part " <<  part++ << "\n" << endl;

   // Part 10 - Goal: To populate a C-style array of 40 million elements with random values between 
   //          1 and 4 billion and then sort via sort() algorithm. Note that you should use the new 
   //          operator to allocate the array.

   // NOTE: The array is created/initialized with with 40 million elements using new operator.

   start_time = time(NULL); // record start time

   {
      size_t* arr = new size_t[forty_million];
      for (size_t i = 0; i < forty_million; ++i) {
         arr[i] = randomInt(engine);
      }
      sort(arr, arr + forty_million);
      delete[] arr;
   }

   end_time = time(NULL); // record end time
   total_time = end_time - start_time; // calculate time to compute
   cout << "It took " << static_cast<long>(total_time) << " seconds to compute Part " << part++ << "\n" << endl;

   // Part 11 - Goal: To populate a multiset of 10 million elements with random values between 
   //          1 and 4 billion.  Note that multiset automatically sorts data so no explicit sort is required.

   // NOTE: The multiset is created/initialized with 0 elements (size() == 0)

   start_time = time(NULL); // record start time

   {
      multiset<size_t> ms;
      for (size_t i = 0; i < ten_million; ++i) {
         ms.insert(randomInt(engine));
      }
   }

   end_time = time(NULL); // record end time
   total_time = end_time - start_time; // calculate time to compute
   cout << "It took " << static_cast<long>(total_time) << " seconds to compute Part " << part++ << "\n" << endl;

   // Part 12 - Goal: To populate a list of 10 million elements with random values between 
   //          1 and 4 billion.  Then sort the list using the sort() member function (not the sort() algorithm).
   //          Lastly use the unique() member function to remove duplicates.

   // NOTE: The list is created/initialized with 0 elements (size() == 0)

   start_time = time(NULL); // record start time

   {
      list<size_t> l;
      for (size_t i = 0; i < ten_million; ++i) {
         l.push_back(randomInt(engine));
      }
      l.sort();
      l.unique();
   }

   end_time = time(NULL); // record end time
   total_time = end_time - start_time; // calculate time to compute
   cout << "It took " << static_cast<long>(total_time) << " seconds to compute Part " << part++ << "\n" << endl;

   // Part 13 - Goal: To populate a set of 10 million elements with random values between 
   //          1 and 4 billion.  This container automatically sorts values and does not insert duplicates.

   // NOTE 1: The set is created/initialized with 0 elements (size() == 0)

   // NOTE 2: You need to ensure there are 10 million values in the set when task is completed.
   //         Keep in mind that you will likely generate some duplicate random values which 
   //             will not be inserted in the set.

   start_time = time(NULL); // record start time

   {
      set<size_t> s;
      while (s.size() < ten_million) {
         s.insert(randomInt(engine));
      }
   }

   end_time = time(NULL); // record end time
   total_time = end_time - start_time; // calculate time to compute
   cout << "It took " << static_cast<long>(total_time) << " seconds to compute Part " << part++ << "\n" << endl;

   system("pause");

} // end main

