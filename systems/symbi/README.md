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

# Run the query

```
./SymBi/symbi <base_graph_file> <insert_graph_file> <query_graph_file>
```




