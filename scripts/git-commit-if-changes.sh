#!/usr/bin/env bash
# Commits all changes to your current branch if there are uncommitted changes.
# Uses the first parameter as the commit message

COMMIT_MESSAGE=$1

clean=$(git status | grep "nothing to commit")

if [[ -z "$clean" ]]; then
    echo There are uncommitted changes. Commiting and pushing them with message: ${COMMIT_MESSAGE}
    git add -A
    git commit -m "$COMMIT_MESSAGE"
    git push
else
    echo There are no uncommited changes.
fi
