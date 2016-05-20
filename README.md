Invariants:
Ensure you have an API key from api.data.gov.  That's about it.
Just make sure the property in api.properties is defined, and 
the framework should do the rest.  

Environmental Concerns:  
Linux-x64  Ubuntu-15.04.  
Java 7.  Maven3  
mvn clean install from the root of the repo should the trick 

Implementation quirks, gotchas, and things to know:
Unlike my normal style, I did not go the full gamut with 
enabling strict ssh on these tests. I've done it before, but 
the box I developed on is a personal box.  

The test runs ARE idempotent.  Re-runs should go just as smoothly
as the one's before them.  

I did notice that in the requirements an assertion was specified 
that the HYATT AUSTIN should be on Barton Springs, it's actually
Barton Springs Rd. Relatively Minor, but I wanted to provide 
full disclosure anyway.   