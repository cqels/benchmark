#!/bin/bash

# Get the directory from the first argument
directory="$1"

# Get the absolute path
absolute_path=$(realpath "$directory")

# Print the absolute path
echo "The absolute path of '$directory' is: $absolute_path"

# Check if the directory exists
if [ ! -d "$absolute_path" ]; then
    echo "Directory does not exist: $absolute_path"
    exit 1
fi

# Initialize line counter
total_lines=0

# Debugging: List all files in the directory
echo "Files in the directory:"
ls -l "$absolute_path"

# Loop through all .txt files in the specified directory
for file in "$absolute_path"/*.csv; do
    if [[ -f "$file" ]]; then  # Check if it's a file
        lines=$(wc -l < "$file")  # Count lines in the file
        echo "Counting lines in file: $file"
        total_lines=$((total_lines + lines))  # Add to total
    else
        echo "No text files found in $absolute_path"
    fi
done

# Output the total count of lines
echo "Total lines in all text files: $total_lines"
