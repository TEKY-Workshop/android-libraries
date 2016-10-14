Networking
===

JSON Parsing
---

[Jackson](http://wiki.fasterxml.com/JacksonHome) is a Java library for converting Objects into JSON and vice-versa. [Gson](https://code.google.com/p/google-gson/) is a popular choice for solving this problem, however we find Jackson to be more performant since it supports alternative ways of processing JSON: streaming, in-memory tree model, and traditional JSON-POJO data binding. Keep in mind, though, that Jackson is a larger library than Gson, so depending on your case, you might prefer Gson to avoid 65k methods limitation. Other alternatives: [Json-smart](https://code.google.com/p/json-smart/) and [Boon JSON](https://github.com/RichardHightower/boon/wiki/Boon-JSON-in-five-minutes). For getting something up and running quickly, GSON will be the easier choice, however Jackson can be helpful when the datamodel becomes complicated, or you don't want to name your variables to match the JSON payload.

For example, Jackson could parse the following JSON

```JSON
{
    "name": "some name",
    "id": 12,
    "innerPropertyList": [
        {
            "innerString": "one inner string"
        }, 
        {
            "innerString": "two inner string"
        }
    ]
}
```

with the following annotated classes

```Java
// The inner class for the list
public class OtherJacksonClass {

  // this uses the @JsonProperty annotation which accesses a public property of the class
  @JsonProperty("innerString") public String innerPropertyString;

}

// This class parses the body of the JSON
// Uses the @JsonGetter and @JsonSetter annotations to specify getters and setters to use
public class MyJacksonAnnotatedClass {

  private String name;
  private Integer id;
  private List<OtherJacksonClass> innerPropertyList;

  @JsonGetter("name")
  public String getName() {
    return name;
  }

  @JsonSetter("name")
  public void setName(String name) {
    this.name = name;
  }

  @JsonGetter("id")
  public Integer getId() {
    return id;
  }

  @JsonSetter("id")
  public void setId(Integer id) {
    this.id = id;
  }

  @JsonGetter("innerPropertyList")
  public List<OtherJacksonClass> getInnerPropertyList() {
    return innerPropertyList;
  }

  @JsonSetter("innerPropertyList")
  public void setInnerPropertyList(List<OtherJacksonClass> innerPropertyList) {
    this.innerPropertyList = innerPropertyList;
  }
}

```

Networking, caching, and images.
---
There are a couple of battle-proven solutions for performing requests to backend servers, which you should use perform considering implementing your own client. Use [Volley](https://android.googlesource.com/platform/frameworks/volley) or [Retrofit](http://square.github.io/retrofit/). We tend to use Retrofit more often as it makes use of RxJava trivial for handling responses. Volley also provides helpers to load and cache images. If you choose Retrofit, consider [Picasso](http://square.github.io/picasso/) for loading and caching images, and [OkHttp](http://square.github.io/okhttp/) for efficient HTTP requests. All three Retrofit, Picasso and OkHttp are created by the same company, so they complement each other nicely. [OkHttp can also be used in connection with Volley](http://stackoverflow.com/questions/24375043/how-to-implement-android-volley-with-okhttp-2-0/24951835#24951835). [Glide](https://github.com/bumptech/glide) is another option for loading and caching images. It has better performance than Picasso, GIF and circular image support, but also a bigger method count.

Example of using Retrofit:

```Java
public interface GitHubService {
  @GET("users/{user}/repos")
  Call<List<Repo>> listRepos(@Path("user") String user);
}

Retrofit retrofit = new Retrofit.Builder()
    .baseUrl("https://api.github.com/")
    .build();

GitHubService service = retrofit.create(GitHubService.class);

Call<List<Repo>> repos = service.listRepos("octocat");
```

Loading images with Picasso/Glide

```Java
// Picasso
Picasso.with(context).load("http://goo.gl/gEgYUd").into(imageView);

// Glide
Glide.with(context).load("http://goo.gl/gEgYUd").into(imageView);
```



RxJava
===
[RxJava](https://github.com/ReactiveX/RxJava/wiki) is a library for Reactive Programming, in other words, handling asynchronous events. It is a powerful and promising paradigm, which can also be confusing since it's so different. It is recommended to take some caution before using this library to architect the entire application. There are some projects done by us using RxJava (Careers, Scribblit).

If you have no previous experience with Rx, start by applying it only for responses from the API. Alternatively, start by applying it for simple UI event handling, like click events or typing events on a search field. If you are confident in your Rx skills and want to apply it to the whole architecture, then write Javadocs on all the tricky parts. Keep in mind that another programmer unfamiliar to RxJava might have a very hard time maintaining the project. Do your best to help them understand your code and also Rx.

Examples:

```Java
 PublishSubject<Integer> subject = PublishSubject.create();
    subject.onNext(1);
    subject.subscribe(System.out::println);
    subject.onNext(2);
    subject.onNext(3);
    subject.onNext(4);
```

Output would look like

```Java
    2
    3
    4
```

[Great tutorial on using RxJava by Dan Lewis](http://blog.danlew.net/2014/09/15/grokking-rxjava-part-1/)

Retrolambda
===

[Retrolambda](https://github.com/evant/gradle-retrolambda) is a Java library for using Lambda expression syntax in Android and other pre-JDK8 platforms. It helps keep your code tight and readable especially if you use a functional style with for example with RxJava.

Android Studio offers code assist support for Java8 lambdas. If you are new to lambdas, just use the following to get started:

Any interface with just one method is "lambda friendly" and can be folded into the more tight syntax
If in doubt about parameters and such, write a normal anonymous inner class and then let Android Studio fold it into a lambda for you.

Examples:

```Java
view.setOnClickListener(new View.OnClickListener() {
    @Override public void onClick(View v) {
        // do something on click     
    }
});
```

becomes

```Java
view.setOnClickListener(v -> {
    // do something on click
});
```

Binding Views
===

[Butterknife](http://jakewharton.github.io/butterknife/) is the best library for binding views, drawables, strings etc. Uses a simple annotations system.

```Java 
@BindView(R.id.my_view) View myView
@BindString(R.string.title) String title;
@BindDrawable(R.drawable.graphic) Drawable graphic;
@BindColor(R.color.red) int red; // int or ColorStateList field
@BindDimen(R.dimen.spacer) Float spacer; // int (for pixel size) or float (for exact value) field
``` 
and a call to a static method.

```Java
 Butterknife.bind(this)
```

Utility Libraries
===

Time/Dates
---

[Joda Time](http://www.joda.org/joda-time/) is hands down the best java library for handling dates and times. Only thing to keep in mind is their objects are Immutable, meaning to do computation you need to make a new object.

Example from their website

```Java
public boolean isAfterPayDay(DateTime datetime) {
  if (datetime.getMonthOfYear() == 2) {   // February is month 2!!
    return datetime.getDayOfMonth() > 26;
  }
  return datetime.getDayOfMonth() > 28;
}

public Days daysToNewYear(LocalDate fromDate) {
  LocalDate newYear = fromDate.plusYears(1).withDayOfYear(1);
  return Days.daysBetween(fromDate, newYear);
}

public boolean isRentalOverdue(DateTime datetimeRented) {
  Period rentalPeriod = new Period().withDays(2).withHours(12);
  return datetimeRented.plus(rentalPeriod).isBeforeNow();
}

public String getBirthMonthText(LocalDate dateOfBirth) {
  return dateOfBirth.monthOfYear().getAsText(Locale.ENGLISH);
}
```

Material Dialogs
---

[Material Dialogs](https://github.com/afollestad/material-dialogs) Super simple way to make material design dialogs. Also Supports custom views when you need something inside the dialog besides what is offered by default.


![Screenshots](https://raw.githubusercontent.com/afollestad/material-dialogs/master/art/readmeshowcase.png)

Building a dialog is as simple as

```Java
new MaterialDialog.Builder(this)
        .title(R.string.title)
        .content(R.string.content)
        .positiveText(R.string.agree)
        .negativeText(R.string.disagree)
        .show();
```

