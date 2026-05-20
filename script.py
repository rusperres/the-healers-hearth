#!/usr/bin/env python3

from pathlib import Path
import argparse
import builtins

# Android / Kotlin specific ignored folders
IGNORED_DIRS = {
    ".git",
    ".gradle",
    ".idea",
    "build",
    ".cxx",
    "captures",
    ".kotlin",
    "externalNativeBuild",
    "generated",
    "out",
}

# Ignore generated/binary files
IGNORED_EXTENSIONS = {
    ".iml",
    ".apk",
    ".aab",
    ".dex",
    ".class",
    ".jar",
    ".so",
    ".png",
    ".jpg",
    ".jpeg",
    ".webp",
    ".mp4",
    ".keystore",
}

MAX_DEPTH = None  # Example: set to 5 to limit recursion depth


def should_ignore(entry: Path):
    if entry.name in IGNORED_DIRS:
        return True

    if entry.suffix.lower() in IGNORED_EXTENSIONS:
        return True

    return False


def generate_tree(path: Path, output_lines, prefix="", depth=0):
    if MAX_DEPTH is not None and depth > MAX_DEPTH:
        return

    try:
        entries = sorted(
            [e for e in path.iterdir() if not should_ignore(e)],
            key=lambda e: (e.is_file(), e.name.lower())
        )

    except PermissionError:
        line = prefix + "└── [Permission Denied]"
        builtins.print(line)
        output_lines.append(line)
        return

    total = len(entries)

    for index, entry in enumerate(entries):
        connector = "└── " if index == total - 1 else "├── "

        if entry.is_dir():
            line = prefix + connector + f"{entry.name}/"
        else:
            line = prefix + connector + entry.name

        builtins.print(line)
        output_lines.append(line)

        if entry.is_dir():
            extension = "    " if index == total - 1 else "│   "

            generate_tree(
                entry,
                output_lines,
                prefix + extension,
                depth + 1
            )


def main():
    parser = argparse.ArgumentParser(
        description="Generate Android Studio Kotlin project structure map"
    )

    parser.add_argument(
        "root",
        nargs="?",
        default=".",
        help="Root Android project folder"
    )

    parser.add_argument(
        "-o",
        "--output",
        help="Save output to file"
    )

    args = parser.parse_args()

    root_path = Path(args.root).resolve()

    if not root_path.exists():
        print("Path does not exist.")
        return

    if not root_path.is_dir():
        print("Path is not a directory.")
        return

    output_lines = []

    root_line = root_path.name + "/"
    builtins.print(root_line)
    output_lines.append(root_line)

    generate_tree(root_path, output_lines)

    if args.output:
        with open(args.output, "w", encoding="utf-8") as f:
            f.write("\n".join(output_lines))

        print(f"\nSaved project map to: {args.output}")


if __name__ == "__main__":
    main()#!/usr/bin/env python3

from pathlib import Path
import argparse
import builtins

# Android / Kotlin specific ignored folders
IGNORED_DIRS = {
    ".git",
    ".gradle",
    ".idea",
    "build",
    ".cxx",
    "captures",
    ".kotlin",
    "externalNativeBuild",
    "generated",
    "out",
}

# Ignore generated/binary files
IGNORED_EXTENSIONS = {
    ".iml",
    ".apk",
    ".aab",
    ".dex",
    ".class",
    ".jar",
    ".so",
    ".png",
    ".jpg",
    ".jpeg",
    ".webp",
    ".mp4",
    ".keystore",
}

MAX_DEPTH = None  # Example: set to 5 to limit recursion depth


def should_ignore(entry: Path):
    if entry.name in IGNORED_DIRS:
        return True

    if entry.suffix.lower() in IGNORED_EXTENSIONS:
        return True

    return False


def generate_tree(path: Path, output_lines, prefix="", depth=0):
    if MAX_DEPTH is not None and depth > MAX_DEPTH:
        return

    try:
        entries = sorted(
            [e for e in path.iterdir() if not should_ignore(e)],
            key=lambda e: (e.is_file(), e.name.lower())
        )

    except PermissionError:
        line = prefix + "└── [Permission Denied]"
        builtins.print(line)
        output_lines.append(line)
        return

    total = len(entries)

    for index, entry in enumerate(entries):
        connector = "└── " if index == total - 1 else "├── "

        if entry.is_dir():
            line = prefix + connector + f"{entry.name}/"
        else:
            line = prefix + connector + entry.name

        builtins.print(line)
        output_lines.append(line)

        if entry.is_dir():
            extension = "    " if index == total - 1 else "│   "

            generate_tree(
                entry,
                output_lines,
                prefix + extension,
                depth + 1
            )


def main():
    parser = argparse.ArgumentParser(
        description="Generate Android Studio Kotlin project structure map"
    )

    parser.add_argument(
        "root",
        nargs="?",
        default=".",
        help="Root Android project folder"
    )

    parser.add_argument(
        "-o",
        "--output",
        help="Save output to file"
    )

    args = parser.parse_args()

    root_path = Path(args.root).resolve()

    if not root_path.exists():
        print("Path does not exist.")
        return

    if not root_path.is_dir():
        print("Path is not a directory.")
        return

    output_lines = []

    root_line = root_path.name + "/"
    builtins.print(root_line)
    output_lines.append(root_line)

    generate_tree(root_path, output_lines)

    if args.output:
        with open(args.output, "w", encoding="utf-8") as f:
            f.write("\n".join(output_lines))

        print(f"\nSaved project map to: {args.output}")


if __name__ == "__main__":
    main()
