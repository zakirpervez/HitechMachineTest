<h1>Hitech Machine Test</h1>
<p>The HiTechMachineTest app is designed to showcase proficiency in Android development and programming skills.</p>

<h2>Getting Started</h2>
<p>Discover the latest signup and preview experience.</p>

<h3>Software Stack:</h3>
<ol>
<li>Android SDK</li>
<li>Kotlin</li>
<li>Compose</li>
<li>Jetpack Navigation Component</li>
<li>Android Architecture Components</li>
<li>Coil</li>
<li>Retrofit</li>
<li>Hilt Dagger</li>
<li>Coroutines</li>
<li>MVVM</li>
<li>Junit4</li>
<li>MockK</li>
<li>Other</li>
</ol>

<h3>Git branching strategy</h3>
<p>A Git branching strategy is a set of rules and guidelines for managing and organizing branches in a Git repository. 
It helps teams collaborate, maintain code quality, and streamline the development process. 
There are several branching strategies like Truncate based development, Git Flow etc.</p>

<p>For this project, I plan to use a truncate-based development strategy. Given that I am the sole contributor in this project, using this approach aligns well with the project's needs.</p>
<ol>
<li>`main` - Main branch, always stable and ready to deploy. </li>
<li>All the feature branches should be created from master branch. </li>
<li>All the feature branches should be merged into master branch.</li>
</ol>

*Note: As I am single developer, I am not creating any feature branches. I am directly pushing the
code to master branch.*

<h3>Commit guidelines</h3>
<p>Commit should always be make in following format</p>
<p>type(scope): [commit-details-message]-[ticket/issue_number]</p>

*Note: I didn't used the appropriate commit guidelines in this project. However above are some
guidelines which I had in my mind. *

<p>type: Type should be represent the nature of commit. It can be one of the following.</p>
<ol>
<li>feat: A new code which is return for the feature.</li>
<li>fix: A bug fix.</li>
<li>refactor: A modification inside the existing code.</li>
<li>docs: Documentation only changes.</li>
<li>release: Release of new version.</li>
<li>test: Adding or updating tests.</li>
<li>chore: Updating build tasks, package manager configs, etc; no production code change.</li>
</ol>

<p>scope: Scope indicates the module, component, or part of the project the commit affects. It can be one of the following.</p>
<ol>
<li>Component</li>
<li>BugFix </li>
<li>Module</li>
<li>App</li>
<li>Api</li>
</ol>

<p>commit-details-message: A short, concise summary of the changes.</p>

<p>ticket/issue_number: Represent JIRA/Github/Gitlab ticket/issue number.</p>

* Note:

<ol>
<li>There is no git pre-hooks added.</li>
<li>As I don't have any JIRA/Github/Gitlab ticket/issue number, I am assuming a ticket no TN:10000 and adding it in my commits.</li>
<li>No CI/CD integration [Gitlab/Github/Bitrise/Bamboo/Fastlane etc would be good candidates]</li>
</ol>
*

<h3>Architecture Used</h3>
This is application is built using a MVVM architecture.
<img src="./screenshots/mvvm_architecture.png" width="960px" height="720" alt="mvvm_architecture"/>
<h3>Testing</h3>
<ol>
<li>Unit Testing: Unit test cases are added.</li>
<li>Instrumentation Testing: No instrumentation test cases are added.</li>
</ol>

<h3>Security</h3>
<ol>
<li>Network security config added</li>
<li>Proguard/Dexguard not added</li>
</ol>

*Note: Not adding the proguard/dexguard.*

<h3>Interceptor/CodeAnalysis/Logging/Memory Detection Tools</h3>

<p>Integrated following tools inside the app</p>
<ol>
<li><b>lint:</b><p>Lint is a static code analysis tool provided by Android Studio. It helps identify issues in Android project code that may cause runtime errors, security vulnerabilities, performance problems, or other code quality problems. Lint performs a wide range of checks, including identifying unused resources, detecting layout performance issues, highlighting potential security vulnerabilities, and more. It provides suggestions and warnings to help developers write better code and follow best practices.</p></li>
<li><b>kt-lint:</b><p>KtLint is a Kotlin-specific code style checker and formatter. It enforces a consistent coding style in Kotlin projects by defining coding rules and then applying those rules to the source code. KtLint helps maintain a uniform and readable codebase by automatically formatting code and highlighting deviations from the defined style rules. It is often used in conjunction with Kotlin projects to ensure code consistency and adherence to a project's coding standards.</p></li>
<li><b>detekt:</b><p> Detekt is a static code analysis tool for Kotlin that helps developers identify issues and enforce coding standards in Kotlin codebases. Similar to Lint for Android, Detekt analyzes Kotlin code for various issues, such as complexity, code smells, potential bugs, and anti-patterns. It provides a set of configurable rules to detect issues and can be customized to match the coding standards and guidelines of a project.</p></li>
<li><b>leak canary:</b>
<p>LeakCanary is a memory leak detection library for Android applications. It helps developers identify and diagnose memory leaks in their apps. Memory leaks can lead to increased memory consumption and application crashes, so LeakCanary is a valuable tool for finding and fixing such issues. It automatically detects and reports memory leaks, providing detailed information about the leaking objects and their references, making it easier to address the problem.</p>
<img src="./screenshots/leak_canary.jpeg" width="540" height="1170" alt="leak_canary">
</li>
<li><b>Timber:</b><p>Timber is a popular logging library for Android applications. It provides a simple and efficient way to log messages and debug information in your Android app. Timber offers several benefits over the standard Android logging methods</p></li>
</ol>

*Note : No other network interceptor and crashing tools are added [Chuck/Stetho/Crashlytics/Sentry]*

<h3>App Screens</h3>

<ol>
<li>
Splash Screen: Pause for a duration of 3 seconds before transitioning to the Signup Screen..<br>
<img src="./screenshots/splash_screen.jpeg" width="540" height="1170" alt="splash_screen"/>
</li>

<li>
Signup Screen: Present a signup form featuring validation checks. Once the user successfully passes all validations, seamlessly transmit the signup form data to the Profile Review Screen utilizing a SharedViewModel for efficient communication.<br><br>
<img src="./screenshots/signup_screen.jpeg" width="540" height="1170" alt="Signup_Screen"/>
</li>

<li>
Profile Review Screen: Display the information originating from the signup screen, and upon clicking the sign-in button, initiate a call to the JsonPlaceHolder users API to refresh and synchronize the user data.<br><br>
<img src="./screenshots/profile_review_screen.jpeg" width="540" height="1170" alt="profile_review_screen"/>
</li>
</ol>

