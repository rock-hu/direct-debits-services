# plop    

`plop --help`

```

Usage:
  $ plop                 Select from a list of available generators
  $ plop <name>          Run a generator registered under that name
  $ plop <name> [input]  Run the generator with input data to bypass prompts

Options:
  -h, --help             Show this help display
  -t, --show-type-names  Show type names instead of abbreviations
  -i, --init             Generate a basic plopfile.js
  -v, --version          Print current version
  -f, --force            Run the generator forcefully

 ------------------------------------------------------
  ⚠  danger waits for those who venture below the line

  --plopfile             Path to the plopfile
  --cwd                  Directory from which relative paths are calculated against while locating the plopfile
  --preload              String or array of modules to require before running plop
  --dest                 Output to this directory instead of the plopfile's parent directory
```

```bash
plop change-package --artifact ---package 
```