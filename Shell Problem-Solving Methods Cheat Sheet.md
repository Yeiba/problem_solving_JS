# Shell Problem-Solving Methods Cheat Sheet

## 🔧 Core Shell Problem-Solving Patterns

### **Text Processing Pipeline**

```bash
# Pattern: input | filter | transform | output
cat file.txt | grep "pattern" | sed 's/old/new/g' | sort | uniq
```

### **Conditional Execution**

```bash
# Pattern: command && success_action || failure_action
mkdir dir && cd dir || echo "Failed to create directory"

# Pattern: test conditions
[[ -f "$file" ]] && echo "File exists" || echo "File not found"
```

### **Loop Patterns**

```bash
# For files
for file in *.txt; do
    [[ -f "$file" ]] && process "$file"
done

# For lines
while IFS= read -r line; do
    echo "Processing: $line"
done < input.txt

# For command output
for user in $(cut -d: -f1 /etc/passwd); do
    echo "User: $user"
done
```

### **Error Handling Pattern**

```bash
# Pattern: Check exit status
if ! command; then
    echo "Command failed" >&2
    exit 1
fi

# Pattern: Set error handling
set -euo pipefail  # Exit on error, undefined vars, pipe failures
```

## 📝 Text Processing & Filtering

### **grep - Pattern Matching**

```bash
# Basic patterns
grep "pattern" file.txt
grep -i "case_insensitive" file.txt
grep -v "exclude_pattern" file.txt
grep -n "show_line_numbers" file.txt

# Advanced patterns
grep -E "regex|pattern" file.txt          # Extended regex
grep -r "recursive_search" directory/     # Recursive
grep -l "pattern" *.txt                   # List filenames only
grep -c "pattern" file.txt                # Count matches
grep -A 2 -B 2 "pattern" file.txt        # Context lines

# Problem-solving patterns
grep -o "extract_only_match" file.txt     # Extract matches
grep -P "\d+" file.txt                    # Perl regex for digits
```

### **sed - Stream Editor**

```bash
# Basic substitution
sed 's/old/new/' file.txt                # Replace first occurrence
sed 's/old/new/g' file.txt               # Replace all occurrences
sed 's/old/new/2' file.txt               # Replace 2nd occurrence

# Line operations
sed '5d' file.txt                         # Delete line 5
sed '1,3d' file.txt                       # Delete lines 1-3
sed -n '5,10p' file.txt                   # Print lines 5-10
sed '5i\New line' file.txt               # Insert before line 5
sed '5a\New line' file.txt               # Append after line 5

# Advanced patterns
sed -E 's/([0-9]+)/[\1]/g' file.txt      # Capture groups
sed '/pattern/d' file.txt                # Delete lines matching pattern
sed '/start/,/end/d' file.txt            # Delete range between patterns
```

### **awk - Text Processing**

```bash
# Basic field processing
awk '{print $1}' file.txt                # Print first field
awk '{print $1, $3}' file.txt            # Print specific fields
awk '{print NF, $NF}' file.txt           # Print field count and last field

# Conditional processing
awk '$1 > 100' file.txt                  # Print lines where field 1 > 100
awk '/pattern/ {print $2}' file.txt      # Print field 2 for matching lines
awk 'NR > 1' file.txt                    # Skip header line

# Calculations
awk '{sum += $1} END {print sum}' file.txt          # Sum column
awk '{print $1, $2, $1*$2}' file.txt               # Calculate new field
awk '{if($1>max) max=$1} END {print max}' file.txt  # Find maximum

# Field separators
awk -F: '{print $1}' /etc/passwd          # Use colon as separator
awk -F',' '{print $2}' file.csv           # Process CSV
```

### **cut - Field Extraction**

```bash
cut -d: -f1 /etc/passwd                   # Extract field 1 with colon delimiter
cut -c1-10 file.txt                       # Extract characters 1-10
cut -d' ' -f2,4 file.txt                  # Extract fields 2 and 4
cut -d',' --complement -f3 file.csv       # All fields except 3
```

### **sort & uniq - Data Organization**

```bash
# Sorting patterns
sort file.txt                             # Alphabetical sort
sort -n file.txt                          # Numerical sort
sort -r file.txt                          # Reverse sort
sort -k2,2n file.txt                      # Sort by 2nd field numerically
sort -t: -k3,3n /etc/passwd               # Sort by 3rd field with delimiter

# Unique operations
uniq file.txt                             # Remove consecutive duplicates
sort file.txt | uniq                      # Remove all duplicates
sort file.txt | uniq -c                   # Count occurrences
sort file.txt | uniq -d                   # Show only duplicates
```

## 📊 File System Operations

### **Find - File Search Patterns**

```bash
# Basic search
find . -name "*.txt"                      # Find by name pattern
find . -type f -name "*.log"              # Find files only
find . -type d -name "temp*"              # Find directories only

# Size and time based
find . -size +100M                        # Files larger than 100MB
find . -mtime -7                          # Modified in last 7 days
find . -atime +30                         # Accessed more than 30 days ago

# Permission based
find . -perm 755                          # Exact permissions
find . -perm -u+w                         # User writable
find . -user username                     # Owned by user

# Execute actions
find . -name "*.tmp" -delete              # Delete matching files
find . -name "*.txt" -exec grep "pattern" {} \;  # Execute command on matches
find . -name "*.log" -exec mv {} backup/ \;      # Move files
```

### **File Operations Patterns**

```bash
# Batch operations
for file in *.txt; do
    mv "$file" "${file%.txt}.bak"         # Change extensions
done

# Directory operations
mkdir -p path/to/nested/dirs              # Create nested directories
cp -r source/ destination/                # Recursive copy
rsync -av source/ destination/            # Efficient sync

# File content operations
head -n 20 file.txt                       # First 20 lines
tail -n 20 file.txt                       # Last 20 lines
tail -f logfile.txt                       # Follow file growth
wc -l file.txt                            # Count lines
wc -w file.txt                            # Count words
```

## 🔄 Process & System Management

### **Process Control Patterns**

```bash
# Background execution
command &                                 # Run in background
nohup command &                           # Run immune to hangups
command > output.log 2>&1 &              # Background with logging

# Process monitoring
ps aux | grep process_name                # Find processes
pgrep -f "process_pattern"                # Process IDs by pattern
pkill -f "process_pattern"                # Kill by pattern
jobs                                      # Show background jobs
fg %1                                     # Bring job to foreground
```

### **System Information Patterns**

```bash
# Disk usage
df -h                                     # Disk space usage
du -sh directory/                         # Directory size
du -h --max-depth=1 | sort -hr           # Largest directories

# Memory and CPU
free -h                                   # Memory usage
top -bn1 | head -20                       # Process snapshot
ps aux --sort=-%cpu | head -10           # Top CPU processes
```

## 🌐 Network & Remote Operations

### **Network Troubleshooting**

```bash
# Connectivity testing
ping -c 4 hostname                        # Test connectivity
telnet host port                          # Test port connectivity
netstat -tuln                            # Show listening ports
ss -tuln                                  # Modern netstat alternative

# Download patterns
curl -O url                               # Download file
wget -r -np -k url                        # Recursive download with wget
curl -s url | grep "pattern"             # Process downloaded content
```

### **Remote Operations**

```bash
# SSH patterns
ssh user@host "command"                   # Execute remote command
ssh -L 8080:localhost:80 user@host        # Port forwarding
scp file.txt user@host:/path/             # Copy file to remote
rsync -av local/ user@host:remote/        # Sync directories
```

## 🔐 Security & Permissions

### **Permission Management**

```bash
# Permission patterns
chmod 755 file                            # Set specific permissions
chmod +x script.sh                        # Add execute permission
chmod -R 644 directory/                   # Recursive permission change
chown user:group file                     # Change ownership

# Security scanning
find . -perm -4000                        # Find SUID files
find . -type f -perm 777                  # Find world-writable files
```

## 📈 Data Analysis Patterns

### **Log Analysis**

```bash
# Extract and analyze log patterns
awk '{print $1}' access.log | sort | uniq -c | sort -nr    # Top IPs
grep "ERROR" app.log | wc -l                                # Error count
awk '{print $9}' access.log | sort | uniq -c               # HTTP status codes

# Time-based analysis
grep "$(date '+%Y-%m-%d')" logfile.log                     # Today's logs
awk -v date="$(date '+%d/%b/%Y')" '$0 ~ date' access.log   # Date filtering
```

### **CSV Processing**

```bash
# CSV analysis patterns
awk -F, '{sum+=$3} END {print "Total:", sum}' data.csv     # Sum column 3
awk -F, 'NR>1 {print $1, $2}' data.csv                    # Skip header
cut -d, -f2 data.csv | sort | uniq -c                     # Count unique values
```

### **Performance Monitoring**

```bash
# System performance patterns
iostat 1 5                                # I/O statistics
vmstat 1 5                                # Virtual memory stats
sar -u 1 10                               # CPU utilization

# Custom monitoring
while true; do
    echo "$(date): $(ps aux | grep process | wc -l) processes"
    sleep 60
done
```

## 🔧 Debugging & Testing

### **Debug Patterns**

```bash
# Script debugging
bash -x script.sh                         # Trace execution
set -x                                     # Enable tracing in script
set +x                                     # Disable tracing

# Testing patterns
if [[ $# -eq 0 ]]; then
    echo "Usage: $0 <argument>" >&2
    exit 1
fi

# Function testing
test_function() {
    local input="$1"
    local expected="$2"
    local result=$(your_function "$input")
    [[ "$result" == "$expected" ]] && echo "PASS" || echo "FAIL: got $result"
}
```

### **Error Handling Patterns**

```bash
# Robust error handling
cleanup() {
    rm -f "$temp_file"
    exit
}
trap cleanup EXIT INT TERM

# Input validation
validate_file() {
    [[ -f "$1" ]] || { echo "File $1 not found" >&2; return 1; }
    [[ -r "$1" ]] || { echo "File $1 not readable" >&2; return 1; }
}
```

## 🏗️ Complex Problem-Solving Patterns

### **Multi-Stage Processing**

```bash
# Pattern: Extract → Transform → Load
extract_data() {
    grep "pattern" raw_data.log
}

transform_data() {
    awk '{print $1, $3, $5}' | sed 's/old/new/g'
}

load_data() {
    while read -r line; do
        echo "$line" >> processed_data.txt
    done
}

# Pipeline
extract_data | transform_data | load_data
```

### **Parallel Processing**

```bash
# Process files in parallel
parallel_process() {
    local file="$1"
    # Process single file
    result=$(complex_operation "$file")
    echo "$file: $result"
}
export -f parallel_process

find . -name "*.txt" | xargs -P 4 -I {} bash -c 'parallel_process "$@"' _ {}
```

### **Configuration Management**

```bash
# Environment-based configuration
case "$ENVIRONMENT" in
    "dev")
        CONFIG_FILE="dev.conf"
        LOG_LEVEL="DEBUG"
        ;;
    "prod")
        CONFIG_FILE="prod.conf"
        LOG_LEVEL="ERROR"
        ;;
    *)
        echo "Unknown environment: $ENVIRONMENT" >&2
        exit 1
        ;;
esac
```

## 🎯 Problem-Solving Decision Tree

### **Text Processing?**

* **Simple search**: `grep`
* **Replace/transform**: `sed`
* **Field processing**: `awk`
* **Extract columns**: `cut`

### **File Operations?**

* **Find files**: `find`
* **Batch operations**: `for` loops with globs
* **Directory operations**: `mkdir -p`, `cp -r`, `rsync`

### **Data Analysis?**

* **Sort/unique**: `sort | uniq`
* **Count/sum**: `awk` with calculations
* **Filter/aggregate**: Pipeline combinations

### **System Tasks?**

* **Process management**: `ps`, `kill`, `jobs`
* **Monitoring**: `top`, `df`, `free`
* **Network**: `ping`, `curl`, `ssh`

### **Automation?**

* **Simple tasks**: Shell functions
* **Complex logic**: Full scripts with error handling
* **Scheduling**: `cron` with robust scripts

## 💡 Best Practices

### **Always Use**

* `set -euo pipefail` for robust scripts
* Quotes around variables: `"$var"`
* Input validation and error checking
* Meaningful variable names
* Functions for reusable code

### **Performance Tips**

* Use built-in commands over external tools when possible
* Pipeline efficiently (avoid unnecessary intermediate files)
* Use `xargs` for batch operations
* Consider `parallel` for CPU-intensive tasks

### **Common Pitfalls to Avoid**

* Unquoted variables leading to word splitting
* Not handling files with spaces in names
* Ignoring exit codes
* Using `ls` output in scripts (use globs instead)
* Not cleaning up temporary files
