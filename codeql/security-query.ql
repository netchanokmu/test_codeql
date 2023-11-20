// codeql/security-query.ql
import javascript

from FunctionCall fc
where
  fc.getTarget().getName() = "eval" or
  fc.getTarget().getName() = "exec"
select fc, "Potential security vulnerability: Use of eval or exec"