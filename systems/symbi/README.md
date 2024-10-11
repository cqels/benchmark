# Github source & Paper



# TODO Docker file for GCC 9.3.0

# Install Symbi
```
    bash install_symbi.sh
```
# Generate data

## LDBC_SNB

### Step 1: Generate LDBC_SNB dataset: [here](../../data/ldbc_snb/README.md)

### Step 2: Convert LDBC_dataset to Symbi Graph format

```
    cd bechmark/system/symbi/data/ldbc_snb/

    python3 ldbc_snb_to_graph.py 0.003 

```

"0.003" is the Scale Factor that use to generate data in the previous step.

### LDBC relations map:

```json
{
    'ForumId': 1,          # ForumId
    'PersonId': 2,         # PersonId
    'id': 3,               # id
    'firstName': 4,        # firstName
    'lastName': 5,         # lastName
    'gender': 6,           # gender
    'birthday': 7,         # birthday
    'locationIP': 8,       # locationIP
    'browserUsed': 9,      # browserUsed
    'LocationCityId': 10,  # LocationCityId
    'language': 11,        # language
    'email': 12,           # email
    'likes': 13,           # PostId
    'title': 14,           # title
    'ModeratorPersonId': 15, # ModeratorPersonId
    'imageFile': 16,       # imageFile
    'content': 17,         # content
    'length': 18,          # length
    'CreatorPersonId': 19, # CreatorPersonId
    'ContainerForumId': 20, # ContainerForumId
    'LocationCountryId': 21, # LocationCountryId
    'TagId': 22,           # TagId
    'ParentPostId': 23,    # ParentPostId
    'ParentCommentId': 24,  # ParentCommentId
    'CommentId': 25,       # CommentId
    'knows': 27,       # Person2Id
    'studyAt': 28,         # UniversityId
    'studyFrom': 29,       # classYear
    'workAt': 30,          # CompanyId
    'workFrom': 31         # workFrom
}
```

# Run the query

```
./SymBi/symbi <base_graph_file> <insert_graph_file> <query_graph_file>
```




